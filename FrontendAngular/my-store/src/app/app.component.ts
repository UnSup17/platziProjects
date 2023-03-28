import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent {
  title = 'my-store';
  name = 'raul';
  btnDisabled = false;
  progreso = 0;
  toggleButton() {
    this.btnDisabled = !this.btnDisabled;
  }
  avanzar() {
    this.progreso += 10;
  }
  onScroll(event: Event) {
    const element = event.target as HTMLElement;
    console.log(element.scrollTop);
  }
  changeName(event: Event) {
    const element = event.target as HTMLInputElement;
    element.value;
  }
}
