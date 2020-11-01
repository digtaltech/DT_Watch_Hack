<template>
<div>
    <h1>Статистика объекта <span style="color: #8074D6">«Мостурбаза»</span></h1>
    <div class="GridOnStatistics">
      <div>
        <div class="card" style="border-radius: 10px; border-color:#E4EBF6;">
          <div class="card-body">
            <div class="row">
              <div class="col-sm">
                <iframe src="https://yandex.ru/map-widget/v1/?um=constructor%3Afa9b36a7f422afd84f249e114092cb60ec4271869484cf6c37e45944d30cd310&amp;source=constructor" width="700" height="400" frameborder="0"></iframe>
              </div>
              <div class="col-sm">
                <h3>Паспорт объекта</h3>
                <v-row class="mx-5 my-5">
                    <h6>Наименование объекта</h6>
                    <v-spacer></v-spacer>
                    <p style="color: #95AAC9">"Мостурбаза"</p>
                </v-row>
                <v-divider style="margin-top: -1rem"></v-divider>
                <v-row class="mx-5 my-4">
                    <h6>Государственный контракт</h6>
                    <v-spacer></v-spacer>
                    <p style="color: #95AAC9">ГК 1342649 от 23.01.2019</p>
                </v-row>
                <v-divider style="margin-top: -1rem"></v-divider>
                <v-row class="mx-5 my-4">
                    <h6>Строительная площадь</h6>
                    <v-spacer></v-spacer>
                    <p style="color: #95AAC9">26352 м2</p>
                </v-row>
                <v-divider style="margin-top: -1rem"></v-divider>
                <v-row class="mx-5 my-4">
                    <h6>Заказчик</h6>
                    <v-spacer></v-spacer>
                    <p style="color: #95AAC9">Департамент строительства</p>
                </v-row>
                <v-divider style="margin-top: -1rem"></v-divider>
                <v-row class="mx-5 my-4">
                    <h6>Генеральный подрядчик</h6>
                    <v-spacer></v-spacer>
                    <p style="color: #95AAC9">ООО «Москапстрой»</p>
                </v-row>
                <v-divider style="margin-top: -1rem"></v-divider>
                <v-row class="mx-5 my-4">
                    <h6>Разрешение на строительство</h6>
                    <v-spacer></v-spacer>
                    <p style="color: #95AAC9">13224 от 11.04.2019</p>
                </v-row>
                <v-divider style="margin-top: -1rem"></v-divider>
              </div>
            </div>
          </div>
        </div>
      </div>
      <div>
        <div class="card" style="border-radius: 10px; border-color:#E4EBF6;">
          <div class="card-body">
            <div class="chart-wrap">
                <div id="chart">
                  <v-row class="mr-2 ml-5">
                      <h5>Кол-во сотрудников по специальностям</h5>
                  </v-row>
                  <v-divider></v-divider>
                    <apexchart type="donut" height="240" :options="chartOptions" :series="series"></apexchart>
                </div>
            </div>
          </div>
        </div>
      </div>
      <div>
        <div class="card" style="border-radius: 10px; border-color:#E4EBF6;">
          <div class="card-body">
            <div class="chart-wrap">
                <div id="chart1">
                  <v-row class="mr-2 ml-5">
                      <h5>Сотрудники на объекте (часы)</h5>
                  </v-row>
                  <v-divider></v-divider>
                    <apexchart type="area" height="240" :options="chartOptions1" :series="series1"></apexchart>
                </div>
            </div>
          </div>
        </div>
      </div>
      <div>
        <div class="card" style="border-radius: 10px; border-color:#E4EBF6;">
          <div class="card-body">
            <div class="chart-wrap">
                <div id="chart2">
                  <v-row class="mr-2 ml-5">
                      <h5>Прибытие сотрудников (дни)</h5>
                  </v-row>
                  <v-divider></v-divider>
                    <apexchart type="area" height="240" :options="chartOptions2" :series="series2"></apexchart>
                </div>
            </div>
          </div>
        </div>
      </div>
    </div>


</div>
</template>
<script>
import VueApexCharts from 'vue-apexcharts'

// const colors = ['#008FFB', '#00E396', '#FEB019', '#FF4560', '#775DD0']
export default {
    components: {
        apexchart: VueApexCharts,
    },
    data() {
        return {
            series: [10, 20, 15, 25, 15, 15],
            chartOptions: {

                labels: ['Бригадир', 'Строитель', 'Слесарь', 'Сварщик', 'Монтажник', 'Геодезист'],
                plotOptions: {
                    pie: {
                        donut: {
                            size: '80%'
                        }
                    }
                },
                // colors: ['#8074D6', '#BCB8D7'],
                chart: {
                    width: 380,
                    type: 'donut',
                },
                dataLabels: {
                    enabled: false
                },
                responsive: [{
                    breakpoint: 480,
                    options: {
                        chart: {
                            width: 200
                        },
                        legend: {
                            show: false
                        }
                    }
                }],
                legend: {
                    position: 'right',
                    offsetY: 0,
                    height: 230,
                }
            },
            series1: [{
                name: 'series1',
                data: [31, 40, 28, 51, 42, 109, 100]
            }, ],
            chartOptions1: {
                chart: {
                    height: 350,
                    type: 'area'
                },
                dataLabels: {
                    enabled: false
                },
                stroke: {
                    curve: 'smooth'
                },
                xaxis: {
                    type: 'datetime',
                    categories: ["2018-09-19T00:00:00.000Z", "2018-09-19T01:30:00.000Z", "2018-09-19T02:30:00.000Z", "2018-09-19T03:30:00.000Z", "2018-09-19T04:30:00.000Z", "2018-09-19T05:30:00.000Z", "2018-09-19T06:30:00.000Z"]
                },
                tooltip: {
                    x: {
                        format: 'dd/MM/yy HH:mm'
                    },
                },
            },
            series2: [{
                name: 'series1',
                data: [52, 20, 18, 51, 42, 109, 100]
            }, ],
            chartOptions2: {
                colors: ["#29CC97"],
                chart: {
                    height: 350,
                    type: 'area'
                },
                dataLabels: {
                    enabled: false
                },
                stroke: {
                    curve: 'smooth'
                },
                xaxis: {
                    type: 'datetime',
                    categories: ["2018-09-19", "2018-09-20", "2018-09-21", "2018-09-22", "2018-09-23", "2018-09-24", "2018-09-25"]
                },
                tooltip: {
                    x: {
                        format: 'dd/MM/yy HH:mm'
                    },
                },
            },

        }
    },
    methods: {

    },
    mounted() {}
};
</script>
<style>
.GridOnStatistics {
    display: grid;
    grid-template-columns: 1fr 1fr 1fr;
    grid-gap: 10px;
}

.GridOnStatistics div:nth-child(1) {
    grid-column: 1 / 4;
}

/* .GridOnUserId div:nth-child(2) {
    grid-column: 2 / 4;
}

.GridOnUserId div:nth-child(3) {
    grid-column: 1 / 3;
}

.GridOnUserId div:nth-child(4) {
    grid-column: 3 / 4;
} */
</style>
