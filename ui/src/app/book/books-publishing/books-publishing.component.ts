import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { BookService} from '../../common/service/book.service';
import { Router} from '@angular/router';

@Component({
  selector: 'app-books-publishing',
  templateUrl: './books-publishing.component.html',
  styleUrls: ['./books-publishing.component.scss']
})
export class BooksPublishingComponent implements OnInit {
  book_id:string;
  purchase_type: number= 1;
  rent_type: number= 2;
  constructor(private router:Router,private bookService: BookService,private activatedRoute:ActivatedRoute) { }

  ngOnInit() {
    this.book_id=this.activatedRoute.snapshot.params['id'];
    console.log(this.book_id);
  }



}
