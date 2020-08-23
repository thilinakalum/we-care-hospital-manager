import {Component, Input, OnInit} from '@angular/core';

@Component({
  selector: 'app-container',
  templateUrl: './container.component.html'
})
export class ContainerComponent implements OnInit {

  @Input() title: String;
  @Input() description: String;

  constructor() { }

  ngOnInit() {
  }

}
