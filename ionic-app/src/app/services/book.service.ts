import { Injectable } from '@angular/core';
import { HttpClient, HttpParams } from '@angular/common/http';
import { Observable } from 'rxjs';


@Injectable({
  providedIn: 'root'
})
export class BookService {

  constructor(protected http: HttpClient) {

  }

  getBooks(): Observable<any> {
    let params = new HttpParams();
    params.set('page', 0);
    params.set('size', 5);
    return this.http.get('http://localhost:8080/books', { params });
  }
}
