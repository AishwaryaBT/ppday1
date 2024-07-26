import { Component } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { of } from 'rxjs';
// import { Customer } from '../../types/Customer';
import { CustomerTS } from '../../types/tstypes/Customerts';
 
@Component({
  selector: 'app-customerarray',
  //standalone: true,
  //imports: [],
  templateUrl: './customerarray.component.html',
  styleUrls: ['./customerarray.component.css']
})
export class CustomerarrayComponent {
  customers: CustomerTS[]=[
    new CustomerTS("John Doe", "john@example.com", "john_doe", "password123", "User", "1")
  ];
 
}
 