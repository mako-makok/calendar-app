import axios from 'axios'

const service = axios.create({
  baseURL: process.env.VUE_APP_BASE_API,
  headers: {
    'Content-Type': 'application/json'
  },
  timeout: 5000
})

service.interceptors.request.use(
  config => {
    return config
  },
  error => {
    Promise.reject(error)
  }
)

service.interceptors.response.use(
  response => {
    const res = response.data
    // if (res.code !== 200) return Promise.reject(new Error(res.message || 'Error'))

    return res
  },
  error => {
    return Promise.reject(error)
  }
)

export default service
