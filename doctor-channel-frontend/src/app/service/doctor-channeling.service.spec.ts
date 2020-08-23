import { TestBed } from '@angular/core/testing';

import { DoctorChannelingService } from './doctor-channeling.service';

describe('DoctorChannelingService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: DoctorChannelingService = TestBed.get(DoctorChannelingService);
    expect(service).toBeTruthy();
  });
});
