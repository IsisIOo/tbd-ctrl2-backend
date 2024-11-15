import { createRouter, createWebHistory } from 'vue-router'
import Principal from "@/views/Principal.vue";
import Registro from "@/views/Registro.vue";
import Tareas from "@/views/Tareas.vue";
import AgregarTarea from "@/views/AgregarTarea.vue";
const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
    {
      path: '/',
      name: 'Principal',
      component: Principal,
    },
    {
      path: '/register',
      name: 'Registro',
      component: Registro,
    },
    {
      path : '/tasks',
      name: 'Tareas',
      component: Tareas,
    },
    {
      path: '/agregar-tarea',
      name: 'AgregarTarea',
      component: AgregarTarea,
    }
  ],
})

export default router
