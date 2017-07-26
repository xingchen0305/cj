import { OnInit, Component, Input, Output, EventEmitter } from '@angular/core';
import {UserService} from "../common/auth/auth.service";
import {Router} from "@angular/router";

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

  constructor(private _userService: UserService,private router: Router) {

  }

  ngOnInit(): void {
    this.resetUser();
  }

  private resetUser() {
    this.user = {username: '', password: '', password2: ''};
  }

  register() {
    this.isSubmitting = true;
    this._userService.register(this.user)
      .subscribe(
        res => {
          this.onDone.emit();
          console.log(this.user);
          this._userService.login(this.user).subscribe(
            data => {
              this._userService.loginSuccess(data);
            }
          );


        },
        error => {
          alert('注册失败');
          this.isSubmitting = false;
        },
        () => {
          this.isSubmitting = false;
        }
      );
  }

  cancel($event) {
    this.onCancel.emit();
  }

}
