import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import 'bootstrap/dist/css/bootstrap.min.css';

@Component({
  selector: 'app-lista-transferencias',
  templateUrl: './lista-transferencias.component.html',
  styleUrls: ['./lista-transferencias.component.css']
})
export class ListaTransferenciasComponent implements OnInit {
  transferencias: any[] = [];

  constructor(private http: HttpClient) { }

  ngOnInit(): void {
    this.http.get<ListaTransferenciasComponent[]>('http://localhost:8080/api/transferencias').subscribe(
      (data) => {
        this.transferencias = data;
      }
    );
  }
}

interface Transferencia {
  tipoOperacao: string;
  contaOrigem: string;
  contaDestino: string;
  valor: number;
  taxa: number;
  dataTransferencia: string;
  dataAgendamento: string;
}