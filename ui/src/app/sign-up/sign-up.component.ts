import { OnInit, Component, Input, Output, EventEmitter } from '@angular/core';

@Component({
  selector: 'sign-up',
  templateUrl: './sign-up.component.html',
  styleUrls: ['./sign-up.component.scss', '../login/login.component.scss']
})
export class SignUpComponent implements OnInit {

  @Input() user: any;

  @Output() onCancel = new EventEmitter();

  @Output() onDone = new EventEmitter();

  private isSubmitting: boolean = false;

  constructor() {

  }

  ngOnInit(): void {
    this.resetUser();
  }

  private resetUser() {
    this.user = {username: '', password: '', password2: ''};
  }

  register() {
    this.isSubmitting = true;
    // this._userService.register(this.user)
    //   .subscribe({
    //     next: res => {
    //       console.log('register next():', res);
    //       if (res.ok) {
    //         this.resetUser();
    //       }
    //       alert(res.message);
    //       this.onDone.emit();
    //     },
    //     complete: () => {
    //       this.isSubmitting = false;
    //     },
    //     error: error => {
    //       alert('注册失败');
    //       this.isSubmitting = false;
    //     }
    //   });
  }

  cancel($event) {
    this.onCancel.emit();
  }

}
