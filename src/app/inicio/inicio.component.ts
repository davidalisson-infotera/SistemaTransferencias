import { Component, OnInit } from '@angular/core';
import axios from 'axios';
import { FormGroup, FormControl, Validators, ReactiveFormsModule } from '@angular/forms';

@Component({
  selector: 'app-inicio',
  templateUrl: './inicio.component.html',
  styleUrls: ['./inicio.component.css']
})
export class InicioComponent implements OnInit {
  transferForm = new FormGroup({
    tipoOperacao: new FormControl('', Validators.required),
    contaOrigem: new FormControl('', Validators.required),
    contaDestino: new FormControl('', Validators.required),
    valor: new FormControl('', Validators.required),
    taxa: new FormControl('', Validators.required),
    dataTransferencia: new FormControl('', Validators.required),
    dataAgendamento: new FormControl('', Validators.required),
  });
  
  tipoOperacao = "";
  contaOrigem = "";
  contaDestino = "";
  valorTransferencia = 0;
  taxa = 0;
  dataTransferencia = new Date();
  dataAgendamento = new Date();

  constructor() { }

  ngOnInit(): void {
  }

  onSubmit(form: FormGroup) {
    this.tipoOperacao = form.value.tipoOperacao;
    this.contaOrigem = form.value.contaOrigem;
    this.contaDestino = form.value.contaDestino;
    this.valorTransferencia = form.value.valor;
    this.taxa = form.value.taxa;
    this.dataTransferencia = form.value.dataTransferencia;
    this.dataAgendamento = form.value.dataAgendamento;
    this.enviarDados();
  }
  
  enviarDados() {
    const transferencia = {
    tipoOperacao : this.tipoOperacao,
    contaOrigem: this.contaOrigem,
    contaDestino: this.contaDestino,
    valor: this.valorTransferencia,
    taxa: this.taxa,
    dataTransferencia: this.dataTransferencia,
    dataAgendamento: this.dataAgendamento
    };
    
    axios.post('http://localhost:8080/api/transferencias', transferencia)
    .then(response => {
    alert("Transferência realizada");
    })
    .catch(error => {
    console.log(error);
    });
    }}
