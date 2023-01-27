import { Book } from "./book";

export interface Review {
  id?: number;
  author?: string;
  created?: string;
  description?: string;
  book?: Book;
}

