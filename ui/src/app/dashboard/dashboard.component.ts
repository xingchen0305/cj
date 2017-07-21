import { Component, OnInit } from '@angular/core';
import { DemoService } from '../common/service/demo.service';

@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.scss']
})
export class DashboardComponent implements OnInit {
  uploadedFiles: any[] = [];
  constructor(private demoService: DemoService) { }

  ngOnInit(): void {
    this.getDemos();
  }

  data: any;
  getDemos() {
    this.demoService.getDemo().subscribe(
      (response) => {
        this.data=response.json();
       // this.data = JSON.stringify(response.json());
        //console.log(this.data);
       // console.log(this.data.id)
        // this.data = response
      }
    );
  }

  myUploader(event) {
    console.log("1");
    console.log(event);
    for(let file of event.files) {
      this.uploadedFiles.push(file);

    }
  }
}
