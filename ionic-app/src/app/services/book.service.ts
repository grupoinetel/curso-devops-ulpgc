import { Injectable } from '@angular/core';
import { HttpClient, HttpParams } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Book } from '../model/book';
import { environment } from '../../environments/environment';


@Injectable({
  providedIn: 'root'
})
export class BookService {

  constructor(protected http: HttpClient) {

  }

  getBooks(size? :number): Observable<Book[]> {
    let params = new HttpParams();
    params = params.append('page', 0);
    params = params.append('size', !!size ? size: 50);
    params = params.append('sortDir', 'asc');
    params = params.append('sort', 'id');
    return this.http.get<Book[]>(environment.urlAPI + '/books', { params });
  }
}
