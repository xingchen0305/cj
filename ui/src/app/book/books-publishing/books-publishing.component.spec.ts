/* tslint:disable:no-unused-variable */
import { async, ComponentFixture, TestBed } from '@angular/core/testing';
import { By } from '@angular/platform-browser';
import { DebugElement } from '@angular/core';

import { BooksPublishingComponent } from './books-publishing.component';

describe('BooksPublishingComponent', () => {
  let component: BooksPublishingComponent;
  let fixture: ComponentFixture<BooksPublishingComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ BooksPublishingComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(BooksPublishingComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
