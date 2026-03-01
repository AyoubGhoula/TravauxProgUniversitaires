import { ComponentFixture, TestBed } from '@angular/core/testing';

import { Enseigant } from './enseigant';

describe('Enseigant', () => {
  let component: Enseigant;
  let fixture: ComponentFixture<Enseigant>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [Enseigant]
    })
    .compileComponents();

    fixture = TestBed.createComponent(Enseigant);
    component = fixture.componentInstance;
    await fixture.whenStable();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
