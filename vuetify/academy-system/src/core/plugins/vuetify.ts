// Styles
import '@mdi/font/css/materialdesignicons.css'
import 'vuetify/styles'

// Vuetify
import { createVuetify } from 'vuetify'
export default createVuetify(
  {
    theme: {
      themes: {
        light: {
          dark: false,
          colors: {
            primary: '#39AC36',
            secondary: "#434343",
            surface: '#E9E9E9',
            "surface-light": "#D9D9D9",
            "on-surface": "#7B7B7B",
            "on-background": '#000000'
          }
        },
      },
    },
  }
)
