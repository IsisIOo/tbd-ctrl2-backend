<template>
    <div class="tarea">
      <h3>{{ tarea.nombre }}</h3>
      <p>{{ tarea.descripcion }}</p>
      <p>Fecha de vencimiento: {{ tarea.fechaEntrega }}</p>
      <p>Estado: {{ tarea.estado }}</p>
  
      <div class="acciones">
        <button @click="editarTarea">Editar</button>
        <button @click="eliminarTarea">Eliminar</button>
        <button @click="marcarCompletada">Marcar como completada</button>
      </div>
    </div>
  </template>

<script>
import { ref } from 'vue'
import axios from 'axios'
import { useRouter } from 'vue-router'

export default{
    
}

</script>

<style scoped>

</style>