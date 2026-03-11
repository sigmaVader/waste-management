import { TestBed } from '@angular/core/testing';

import { WasteServiceService } from './waste-service.service';

describe('WasteServiceService', () => {
  let service: WasteServiceService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(WasteServiceService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
