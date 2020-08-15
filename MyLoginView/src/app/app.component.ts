import { Component, OnInit } from '@angular/core';

import { MsalService, BroadcastService } from '@azure/msal-angular';
import { Logger, CryptoUtils } from 'msal';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})

export class AppComponent implements OnInit{
  title = 'MyLoginView';
  isIframe = false;
  isLoggedIn = false;

  constructor(private broadcastService: BroadcastService, private authService: MsalService) { }

  ngOnInit() { 
    this.isIframe = window !== window.parent && !window.opener;

    this.ValidateAccount();

    this.broadcastService.subscribe('msal:loginSuccess', () => {
      this.ValidateAccount();
    });

    this.authService.handleRedirectCallback((authError, response) => {
      if (authError) {
        console.error('Redirect Error: ', authError.errorMessage);
        return;
      }

      console.log('Redirect Success: ', response.accessToken);
    });

    this.authService.setLogger(new Logger((logLevel, message, piiEnabled) => {
      console.log('MSAL Logging: ', message);
    }, {
      correlationId: CryptoUtils.createNewGuid(),
      piiLoggingEnabled: false
    }));
  }

  ValidateAccount() {
    this.isLoggedIn = !!this.authService.getAccount();
  }

  Login() {
    const isIE = window.navigator.userAgent.indexOf('MSIE ') > -1 || window.navigator.userAgent.indexOf('Trident/') > -1;

    if (isIE) {
      this.authService.loginRedirect();
    } else {
      this.authService.loginPopup();
    }
  }

  Logout() {
    this.authService.logout();
  }
}
