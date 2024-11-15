<template>
    <div >
        <header>
            <h1>Control 2</h1>
            <nav>
                <button> Notificaciones</button>
                <button> Cerrar sesión</button>
            </nav>
        </header>
    </div>
    <div class="botonTareas">
        <button @click="irAAñadir" class="añadirTareas">Añadir tareas</button>
    </div>
    <div class="tareas">
        <h1>Tareas</h1>
        <ul>
            <li v-for="tarea in tareas" :key="tarea.id">{{ tarea.nombre }}</li>
        </ul>
    </div>
</template>

<script>
import { ref } from 'vue'
import axios from 'axios'
import { useRouter } from 'vue-router'
export default {
    name: 'Tareas',
    data() {
        return {
            tareas: [
                { id: 1, nombre: 'Tarea 1' },
                { id: 2, nombre: 'Tarea 2' },
                { id: 3, nombre: 'Tarea 3' }
            ]
        };
    },
    setup() {
        const router = useRouter()
        const irAAñadir = () => {
            router.push('/agregar-tarea')
        }
        return {
            irAAñadir
        }
    }
};
</script>

<style scoped>
header{
    display: flex;
    justify-content: space-between;
    background-color: lightblue;
}
nav{
    display: flex;
    height: 50px;
    gap: 10px;
    margin-top: 15px;
    margin-right: 20px;
}
.botonTareas{
    display: flex;
    justify-content: center;
    margin-right: 20px;
    margin-top: 20px;
}
.tareas {
    padding: 20px;
}

.tareas h1 {
    font-size: 24px;
    margin-bottom: 10px;
}

.tareas ul {
    list-style-type: none;
    padding: 0;
}

.tareas li {
    background: #f9f9f9;
    margin: 5px 0;
    padding: 10px;
    border: 1px solid #ddd;
}
</style>