import { HttpClient, HttpParams } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Review } from '../model/review';


@Injectable({
  providedIn: 'root'
})
export class ReviewService {

  constructor(protected http: HttpClient) { }


  getReviews(): Observable<Review[]> {
    let params = new HttpParams({

    });
    params = params.append('page', 0);
    params = params.append('size', 5);
    params = params.append('sortDir', 'asc');
    params = params.append('sort', 'id');

    return this.http.get<Review[]>('http://localhost:8080/reviews', { params });
  }
}
