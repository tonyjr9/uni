// Estruturas de Dados 2024/2025 (CC1007) - DCC/FCUP
// https://www.dcc.fc.up.pt/~fds/aulas/EDados/2425/
// -----------------------------------------------------------
// Interface para o TAD Pilha
// (Pedro Ribeiro @ DCC-FCUP)
// -----------------------------------------------------------
package com;
public interface MyStack<T> {

    // Metodos que modificam a pilha
    public void push(T v); // Coloca um valor no topo da pilha
    public T pop();        // Retira e retorna o valor no topo da pilha

    // Metodos que acedem a informacao (sem modificar)
    public T top();           // Retorna valor no topo da pilha
    public int size();        // Retorna quantidade de elementos na pilha
    public boolean isEmpty(); // Indica se a pilha esta vazia
}
