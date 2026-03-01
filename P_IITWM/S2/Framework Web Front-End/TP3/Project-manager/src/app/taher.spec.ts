import { TestBed } from '@angular/core/testing';

import { Taher } from './taher';

describe('Taher', () => {
  let service: Taher;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(Taher);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
