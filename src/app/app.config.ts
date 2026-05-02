// import { provideRouter } from '@angular/router';
// import { routes } from './app.routes';
// import { provideHttpClient } from '@angular/common/http';

// export const appConfig = {
//   providers: [
//     provideRouter(routes),
//     provideHttpClient()
//   ]
// };

import { ApplicationConfig } from '@angular/core';
import { provideRouter } from '@angular/router';
import { provideHttpClient } from '@angular/common/http';
import { routes } from './app.routes';

export const appConfig: ApplicationConfig = {
  providers: [
    provideRouter(routes),
    provideHttpClient()
  ]
};