import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { BookService} from '../../common/service/book.service';
import { Router} from '@angular/router';

@Component({
  selector: 'app-purchase-book',
  templateUrl: './purchase-book.component.html',
  styleUrls: ['./purchase-book.component.scss']
})
export class PurchaseBookComponent implements OnInit {
  data:any ={};
  book_id:string;
  purchase_type: number= 1;
  rent_type: number= 2;
  constructor(private router:Router,private bookService: BookService,private activatedRoute:ActivatedRoute) { }

  ngOnInit() {
    this.book_id=this.activatedRoute.snapshot.params['id'];
  }
  onSubmit(value){
    value['type'] = this.purchase_type;
    console.log(value);
    this.bookService.rentBookById(value,this.book_id).subscribe(
      res=> {
        console.log(res);
        alert(" edit success")
        this.router.navigateByUrl("/attendanceRecord");
        }
    )
  }

}
