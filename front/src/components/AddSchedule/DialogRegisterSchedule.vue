<template>
  <v-app>
    <v-dialog v-model="dialog" max-width="600" @click:outside="close">
      <v-card>
        <v-container>
          <v-form>
            <v-row no-gutters>
              <v-col />
              <v-col :cols="11">
                <v-text-field placeholder="タイトルと日時を追加" />
              </v-col>
            </v-row>
            <v-row justify="end" dense>
              <v-col align-self="center" :cols="1">
                <v-icon>
                  schedule
                </v-icon>
              </v-col>
              <v-col>
                <FormDatePicher :propDate="startDate.toISOString().substr(0, 10)" />
              </v-col>
              <v-col v-if="useTime" :cols="2">
                <v-combobox v-model="startTime" :items="times" />
              </v-col>
              <v-col :cols="1" align-self="center" style="text-align: center;">
                <div class="hyphen-to">
                  <p>-</p>
                </div>
              </v-col>
              <v-col v-if="useTime" :cols="2">
                <v-combobox v-model="endTime" :items="times" />
              </v-col>
              <v-col>
                <FormDatePicher :propDate="endDate.toISOString().substr(0, 10)" />
              </v-col>
              <v-col v-if="!useTime" :cols="3" align-self="center">
                <v-btn small text outlined width="80%" @click="useTime = true">
                  時間を追加
                </v-btn>
              </v-col>
            </v-row>
            <v-row no-gutters>
              <v-col :cols="1" align-self="center">
                <v-icon>
                  subject
                </v-icon>
              </v-col>
              <v-col :cols="11">
                <v-text-field placeholder="説明を追加" />
              </v-col>
            </v-row>
            <v-row align="end" dense>
              <v-col :cols="9" />
              <v-col :cols="3">
                <v-btn color="primary" width="80%" @click="close">
                  保存
                </v-btn>
              </v-col>
            </v-row>
          </v-form>
        </v-container>
      </v-card>
    </v-dialog>
  </v-app>
</template>

<script lang="ts">
import { Vue, Component } from 'vue-property-decorator'
import FormDatePicher from '@/components/AddSchedule/FormDatePicher.vue'

@Component({
  components: {
    FormDatePicher
  }
})
export default class DialogRegisterSchedule extends Vue {
  private dialog = false
  private title = ''
  private startDate = new Date()
  private endDate = new Date()
  private startTime = `${this.startDate.getHours()}:${this.startDate.getMinutes()}`
  private endTime = `${this.startDate.getHours()}:${this.startDate.getMinutes() + 15}`
  private description = ''
  private useTime = false
  private times = [...Array(96).keys()].map(
    i => `${('00' + Math.floor((i + 1) / 4)).slice(-2)}:${('00' + (((i + 1) * 15) % 60)).slice(-2)}`
  )

  private register() {
    this.dialog = false
  }

  public open(year: number, month: number, date: number) {
    this.startDate = new Date(year, month, date)
    this.endDate = new Date(year, month, date)
    this.dialog = true
  }

  private close() {
    this.dialog = false
    this.useTime = false
  }
}
</script>

<style lang="scss">
.hyphen-to {
  font-size: 150%;
}
</style>
