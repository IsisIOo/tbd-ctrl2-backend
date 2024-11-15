<template>
    <div class="contenedor">
        <div class="info-login">
            <h1>Inicio de sesión</h1>
            <form @submit.prevent="loginForm">
                <div>
                    <label for="user">Usuario</label>
                    <input type="text" name="user" id="user">
                </div>
                <div>
                    <label for="password">Contraseña</label>
                    <input type="password" name="password" id="password">
                </div>
                <div class="buttons">
                    <button @click="irATareas">Login</button>
                    <button @click="irARegistro">Registrarse</button>
                </div>
        </form>
        <p v-if="mensaje">{{ mensaje }}</p>
        </div>
    </div>
</template>

<script>
import { ref } from 'vue'
import axios from 'axios'
import { useRouter } from 'vue-router'

export default {
  name: "loginView",
  setup() {
    const router = useRouter()
    const irARegistro = () => {
      router.push('/register')
    }
    const irATareas = () => {
      router.push('/tasks')
    }
    return { 
      irARegistro,
        irATareas
    }
  }
}
</script>

<style scoped>
.contenedor {
    display: flex;
    justify-content: center;
    align-items: center;
    height: 100vh;
    width: 100vw;
    box-sizing: border-box;
}

.info-login {
    display: flex;
    flex-direction: column;
    width: 100%;
    max-width: 400px;
    padding: 20px;
    box-sizing: border-box;
    border: 1px solid black;
    border-radius: 5px;
}

input {
    width: 100%;
    padding: 10px;
    margin: 10px 0;
    box-sizing: border-box;
}

.buttons {
    width: 100%;
    display: flex;
    justify-content: space-around;
}
</style>
