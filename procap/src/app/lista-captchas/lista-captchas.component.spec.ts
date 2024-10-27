import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ListaCaptchasComponent } from './lista-captchas.component';

describe('ListaCaptchasComponent', () => {
  let component: ListaCaptchasComponent;
  let fixture: ComponentFixture<ListaCaptchasComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [ListaCaptchasComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(ListaCaptchasComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
