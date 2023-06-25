import { Component, OnInit } from '@angular/core';
import { MatSnackBar } from '@angular/material/snack-bar';
import { UserService } from 'src/app/services/user.service';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-signup',
  templateUrl: './signup.component.html',
  styleUrls: ['./signup.component.css']
})
export class SignupComponent implements OnInit{
  public user={
    username:'',
    password:'',
    firstName:'',
    lastName:'',
    email:''
  }
  constructor(private userService:UserService, private snack: MatSnackBar){

  }
  ngOnInit(): void {
  }
  
  formSubmit(){
    console.log(this.user);
    if (this.user.username==''||this.user.username==null||
    this.user.firstName==''||this.user.firstName==null||
    this.user.lastName==''||this.user.lastName==null,
    this.user.password==''||this.user.password==null,
    this.user.email==''||this.user.email==null)
    {
      this.snack.open("All fields are required to be filled",'OK',{
        duration: 3000
      })
      return;
    }

    //addUser: user service
    this.userService.addUser(this.user).subscribe(
      {
        next: data => console.log(data),
        error: err => {console.error(err); this.snack.open("Something went wrong!",'OK',{
          duration:3000
        });},
        complete: () => {console.log('done'); Swal.fire("Success","User is successfully registered...","success");},
      }
    )
  }
}


