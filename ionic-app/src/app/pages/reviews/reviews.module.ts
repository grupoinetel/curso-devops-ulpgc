import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { IonicModule } from '@ionic/angular';
import { FormsModule } from '@angular/forms';

import { ReviewsPage } from './reviews.page';
import { ReviewsPageRoutingModule } from './reviews-routing.module';
import { MessageComponentModule } from '../../message/message.module';
import { BookService } from '../../services/book.service';
import { HttpClient, HttpClientModule } from '@angular/common/http';
import { ReviewService } from '../../services/review.service';

@NgModule({
  imports: [
    CommonModule,
    FormsModule,
    IonicModule,
    MessageComponentModule,
    ReviewsPageRoutingModule,
    HttpClientModule
  ],
  declarations: [ReviewsPage]
})
export class ReviewsPageModule {}
