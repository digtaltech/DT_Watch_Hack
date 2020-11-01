import VueRouter from 'vue-router'
import Main from './pages/main.vue'
import Staff from './pages/staff.vue'
import Statistics from './pages/statistics.vue'
import Settings from './pages/settings.vue'
import Message from './pages/message.vue'
import Notifications from './pages/notifications.vue'
import Userid from './pages/userid.vue'

export default new VueRouter({
  routes:[
    {
      path: '',
      component: Main
    },
    {
      path: '/staff',
      component: Staff,
      children:[
        {
          path: ':id',
          component: Userid,
          name: 'userid'
        }
      ]
    },
    {
      path: '/statistics',
      component: Statistics
    },
    {
      path: '/statistics',
      component: Statistics
    },
    {
      path: '/settings',
      component: Settings
    },
    {
      path: '/message',
      component: Message
    },
    {
      path: '/notifications',
      component: Notifications
    },

  ],
  mode: 'history'

})
