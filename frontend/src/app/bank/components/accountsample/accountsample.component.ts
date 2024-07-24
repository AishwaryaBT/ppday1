import { Component } from '@angular/core';
import { AccountTS } from '../../types/tstypes/Accountts';

@Component({
  selector: 'app-accountsample',
  standalone: true,
  imports: [],
  templateUrl: './accountsample.component.html',
  styleUrls: ['./accountsample.component.css']
})
export class AccountsampleComponent {
  account:any=AccountTS;
  constructor(){
    this.account=new AccountTS("2",789.00,"2");
    
    
  }




  }


