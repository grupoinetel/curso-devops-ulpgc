import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { ReviewEditionPage } from './review-edition.page';

const routes: Routes = [
  {
    path: '',
    component: ReviewEditionPage
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule],
})
export class ReviewEditionPageRoutingModule {}
