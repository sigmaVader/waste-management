import { ComponentFixture, TestBed } from '@angular/core/testing';

import { WasteRecordComponent } from './waste-record.component';

describe('WasteRecordComponent', () => {
  let component: WasteRecordComponent;
  let fixture: ComponentFixture<WasteRecordComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [WasteRecordComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(WasteRecordComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
