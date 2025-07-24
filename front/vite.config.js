import { defineConfig } from 'vite'
import react from '@vitejs/plugin-react'

export default defineConfig({
  plugins: [react()],
  server: {
    proxy: {
      // Toute requête qui commence par /api sera redirigée vers la gateway backend
      '/api': {
        target: 'http://localhost:8080',
        changeOrigin: true,
        secure: false,
      },
      // Si tu as d'autres endpoints, tu peux ajouter d'autres règles ici
    }
  }
})
