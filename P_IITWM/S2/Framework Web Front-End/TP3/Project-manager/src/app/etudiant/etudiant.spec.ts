import { ComponentFixture, TestBed } from '@angular/core/testing';

import { Etudiant } from './etudiant';

describe('Etudiant', () => {
  let component: Etudiant;
  let fixture: ComponentFixture<Etudiant>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [Etudiant]
    })
    .compileComponents();

    fixture = TestBed.createComponent(Etudiant);
    component = fixture.componentInstance;
    await fixture.whenStable();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
