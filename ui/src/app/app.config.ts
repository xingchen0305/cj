import { FactoryProvider } from '@angular/core';

export function configFactory() {
  return {
    // nodeServer: window['QY_CONFIG'].node_server,
    // apiGateway: window['QY_CONFIG'].api_gateway,
    // webSocketGateway: window['QY_CONFIG'].ws_gateway,
    // loginUrl: window['QY_CONFIG'].node_server + '/loginusr',
    // registerUrl: window['QY_CONFIG'].node_server + '/addnewusr'
  };
}


export function provideAppConfig(): FactoryProvider {
  return {
    provide: 'appConfig',
    useFactory: configFactory
  };
}
