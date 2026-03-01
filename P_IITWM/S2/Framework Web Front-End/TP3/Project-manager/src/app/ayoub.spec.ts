import { TestBed } from '@angular/core/testing';

import { Ayoub } from './ayoub';

describe('Ayoub', () => {
  let service: Ayoub;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(Ayoub);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
