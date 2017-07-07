import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-books-publishing',
  templateUrl: './books-publishing.component.html',
  styleUrls: ['./books-publishing.component.scss']
})
export class BooksPublishingComponent implements OnInit {
  book_id:string;
  book_type: number= -1;
  constructor(private activatedRoute:ActivatedRoute) { }

  ngOnInit() {
    this.book_id=this.activatedRoute.snapshot.params['id'];

  }

}
