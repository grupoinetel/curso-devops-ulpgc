import { Component, OnInit, ViewChild } from '@angular/core';
import { IonInfiniteScroll, NavController } from '@ionic/angular';

import { ReviewService } from '../../services/review.service';
import { Review } from 'src/app/model/review';
import {  NavigationExtras } from '@angular/router';

@Component({
  selector: 'reviews-home',
  templateUrl: 'reviews.page.html',
  styleUrls: ['reviews.page.scss'],
})
export class ReviewsPage implements OnInit {

  @ViewChild(IonInfiniteScroll, { static: true })
  infiniteScroll?: IonInfiniteScroll;

  page = 0;
  size = 7;

  reviews: Review[] = [];
  avatarClasses = ['avatar-rojo', 'avatar-verde', 'avatar-azul-claro', 'avatar-azul-oscuro', 'avatar-violeta', 
                   'avatar-amarillo', 'avatar-rosa', 'avatar-naranja', 'avatar-turquesa', 'avatar-verde-limon'];

  constructor(private reviewsService: ReviewService,
              private navCtrl: NavController) {}
  

  ngOnInit(): void {
    this.loadReviews(false);

    // Nos suscribimos al evento de creación de reseñas para agregarla a la lista
    this.reviewsService.newReview
        .subscribe( review => {
      this.reviews.unshift(review);
    }); 

    // Nos suscribimos al evento de eliminación de reseñas para eliminarla a la lista
    this.reviewsService.deletedReview
        .subscribe( reviewId => {
        const reviewsResult = this.reviews.filter(review => review.id != reviewId);
        this.reviews = [...reviewsResult];
    });
    
  }



  loadReviews(more = false) {
    
    // Si no solicitamos más, es porque estamos pidiendo la primera página
    if (!more) {
      this.page = 0
    }
    
    // Llamamos al servicio para obtener la lista de reseñas pasándole la paǵina y el número
    // de elementos por página
    this.reviewsService.getReviews(this.page, this.size).subscribe(
      (reviewList: Review[]) => {
        
        // Se ha obtenido una respuesta correcta del servicio, añadimos la lista de reseñas 
        // obtenida en la respuesta al atributo reviews
        this.reviews = [...this.reviews, ...reviewList];

        // Si está cargado el infinite scroll y no viene ninguna lista o el tamaño es menor que el número de 
        // elementos por página, entonces  hemos llegado a la última página. Por lo tanto, desactivamos el infinite scroll
        if (!!this.infiniteScroll && (!reviewList || reviewList.length < this.size)) {
          console.log('fin');
            this.infiniteScroll.disabled = true;
            return;
        }
        
        // En caso de no haber llegado a la última página, aumentamos el contador de página y marcamos como completada 
        // la operación del infinite scroll
        this.page++;
        if (!!this.infiniteScroll) {
          this.infiniteScroll.complete();
        }
      }
    )
  }

  addNewReview(): void {
    // Navegamos a la página para crear reseña
    this.navCtrl.navigateForward('review-edition');
  }

  editReview(review: Review): void {
    // Navegamos a la página para editar reseña pasádole la reseña sobre la que hemos clicado
    const navigationExtras: NavigationExtras = {
      queryParams: {
        review
      }
    };
    this.navCtrl.navigateForward('review-edition', navigationExtras);
  }

  getAvatarClass(index: number): string {
   // Obtiene las clases utilizadas en el fondo del avatar del array avatarClasses. Al llegar a 10 vuelve a empezar en 0
   const i = index >= 10 ? index % 10 : index;
   return this.avatarClasses[i];
  }
}
