import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';

import { IonicModule } from '@ionic/angular';

import { ReviewEditionPageRoutingModule } from './review-edition-routing.module';

import { ReviewEditionPage } from './review-edition.page';
import { BookService } from 'src/app/services/book.service';
import { ReviewService } from 'src/app/services/review.service';
import { HttpClientModule } from '@angular/common/http';

@NgModule({
  imports: [
    CommonModule,
    FormsModule,
    IonicModule,
    ReviewEditionPageRoutingModule,
    HttpClientModule
  ],
  declarations: [ReviewEditionPage]
})
export class ReviewEditionPageModule {}
