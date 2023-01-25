import { Component, OnInit } from '@angular/core';
import { RefresherCustomEvent } from '@ionic/angular';

import { DataService, Message } from '../../services/data.service';
import { BookService } from '../../services/book.service';
import { ReviewService } from '../../services/review.service';
import { Review } from 'src/app/model/review';

@Component({
  selector: 'reviews-home',
  templateUrl: 'reviews.page.html',
  styleUrls: ['reviews.page.scss'],
})
export class ReviewsPage implements OnInit{

  reviews: Review[] = [];

  constructor(private data: DataService,
              private reviewsService: ReviewService) { }

  ngOnInit(): void {
    this.reviewsService.getReviews().subscribe(
      (reviewList: Review[]) => {
        this.reviews = reviewList;
      }
    )
  }



  refresh(ev: any) {
    setTimeout(() => {
      (ev as RefresherCustomEvent).detail.complete();
    }, 3000);
  }

  getMessages(): Message[] {
    return this.data.getMessages();
  }

}
