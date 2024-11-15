<template>
    <div class="agregar-tarea">
        <h1>Agregar Tarea</h1>
        <form @submit.prevent="submitForm">
            <div>
                <label for="nombre">Nombre:</label>
                <input type="text" id="nombre" v-model="nombre" required>
            </div>
            <div>
                <label for="descripcion">Descripción:</label>
                <textarea id="descripcion" v-model="descripcion" required></textarea>
            </div>
            <div>
                <label for="fecha">Fecha de Termino:</label>
                <input type="date" id="fecha" v-model="fecha" required>
            </div>
            <button type="submit">Agregar Tarea</button>
        </form>
    </div>
</template>

<script>
export default {
    data() {
        return {
            nombre: '',
            descripcion: '',
            fecha: ''
        };
    },
    methods: {
        submitForm() {
            // Aquí puedes manejar el envío del formulario
            console.log('Nombre:', this.nombre);
            console.log('Descripción:', this.descripcion);
            console.log('Fecha de Termino:', this.fecha);
        }
    }
};
</script>

<style scoped>
.agregar-tarea {
    max-width: 600px;
    margin: 0 auto;
    padding: 20px;
    border: 1px solid #ccc;
    border-radius: 8px;
}

.agregar-tarea h1 {
    text-align: center;
}

.agregar-tarea form div {
    margin-bottom: 15px;
}

.agregar-tarea form label {
    display: block;
    margin-bottom: 5px;
}

.agregar-tarea form input,
.agregar-tarea form textarea {
    width: 100%;
    padding: 8px;
    box-sizing: border-box;
}

.agregar-tarea form button {
    display: block;
    width: 100%;
    padding: 10px;
    background-color: #007bff;
    color: white;
    border: none;
    border-radius: 4px;
    cursor: pointer;
}

.agregar-tarea form button:hover {
    background-color: #0056b3;
}
</style>