<template>
  <div>
    <h1>Уведомления о сотрудниках предприятия <span style="color: #8074D6">«DT»</span></h1>
    <div class="MainGrid mt-4 mr-6">
      <div>
        <div class="card mb-3" style="border-radius: 10px; border-color:#E4EBF6;" v-for="alerts in alerts" v-bind:key="alerts.id">
          <div class="card-body">
              <div class="row">
                <div class="col-2" style="display: flex; justify-content: center; align-items: center;">
                  <v-avatar
                    color="orange"
                    size="62"
                  >
                    <span class="white--text headline">!</span>
                  </v-avatar>
                </div>
                <div class="col-8">
                  <h5>Следует обратить внимание</h5>
                  <p>У сотрудника {{alerts.firstName}} {{alerts.lastName}} наблюдаются проблемы с частотой пульса, рекомендуем обратить на это внимание</p>
                </div>
                <div class="col-2" style="display: flex; justify-content: center; align-items: center;">
                  <v-avatar
                    color="green"
                    size="30"
                  >
                    <span class="white--text headline"></span>
                  </v-avatar>
                </div>
              </div>
            </div>
          </div>
      </div>
      <div>
        <div class="card mb-3" style="border-radius: 10px; border-color:#E4EBF6;">
          <div class="card-body">
            <v-row class="mr-2 ml-5 my-3">
              <h5>Контакты предприятия</h5>
            </v-row>
            <v-divider></v-divider>
              <div class="card" style="border-color: white">
                <div class="card-body">
                    <div class="row">
                      <div class="col-2">
                        <v-avatar
                          color="orange"
                          size="90"
                        >
                        <img
                          alt="user"
                          src="https://cdn.pixabay.com/photo/2020/06/24/19/12/cabbage-5337431_1280.jpg"
                        >
                        </v-avatar>
                      </div>
                      <div class="col-10">
                        <h4>Абрамов Максим</h4>
                        <h6 style="color: #95AAC9">Ответственный за объект</h6>
                        <h6 style="color: #95AAC9">+8 (988) 234 32 12</h6>
                      </div>
                    </div>
                </div>
              </div>
              <div class="card" style="border-color: white">
                <div class="card-body">
                    <div class="row">
                      <div class="col-2">
                        <v-avatar
                          color="orange"
                          size="90"
                        >
                        <img
                          alt="user"
                          src="https://cdn.pixabay.com/photo/2020/06/24/19/12/cabbage-5337431_1280.jpg"
                        >
                        </v-avatar>
                      </div>
                      <div class="col-10">
                        <h4>Чернов Пётр</h4>
                        <h6 style="color: #95AAC9">Охранник</h6>
                        <h6 style="color: #95AAC9">+ 7 (999) 234 32 12</h6>
                      </div>
                    </div>
                </div>
              </div>
            </div>
          </div>
      </div>
    </div>
  </div>
</template>
<script>
import axios from 'axios'
export default {
    data() {
        return {
            alerts: null,
            config: {
                method: 'get',
                url: 'https://api.dt-prod.ru/alert/',
                headers: {
                    Authorization: null
                }
            }
        };

    },
    mounted() {
      axios(this.config)
          .then(response => (this.alerts = response.data));
      console.log(this.alerts)
    }
}
</script>
<style>

</style>
