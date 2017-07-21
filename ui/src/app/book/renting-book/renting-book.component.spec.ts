/* tslint:disable:no-unused-variable */
import { async, ComponentFixture, TestBed } from '@angular/core/testing';
import { By } from '@angular/platform-browser';
import { DebugElement } from '@angular/core';

import { RentingBookComponent } from './renting-book.component';

describe('RentingBookComponent', () => {
  let component: RentingBookComponent;
  let fixture: ComponentFixture<RentingBookComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ RentingBookComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(RentingBookComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
