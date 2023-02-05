import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ListaTransferenciasComponent } from './lista-transferencias.component';

describe('ListaTransferenciasComponent', () => {
  let component: ListaTransferenciasComponent;
  let fixture: ComponentFixture<ListaTransferenciasComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ListaTransferenciasComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ListaTransferenciasComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
