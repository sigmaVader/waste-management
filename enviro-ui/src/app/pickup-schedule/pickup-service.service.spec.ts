import { TestBed } from '@angular/core/testing';

import { PickupServiceService } from './pickup-service.service';

describe('PickupServiceService', () => {
  let service: PickupServiceService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(PickupServiceService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
