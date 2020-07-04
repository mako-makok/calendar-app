<template>
  <v-menu
    ref="menu"
    v-model="menu"
    :close-on-content-click="false"
    transition="scale-transition"
    offset-y
    min-width="290px"
  >
    <template v-slot:activator="{ on }">
      <v-text-field class="date-text-field" v-model="date" v-on="on" />
    </template>
    <v-date-picker
      v-model="date"
      no-title
      scrollable
      locale="jp-ja"
      :day-format="date => new Date(date).getDate()"
      @input="menu = false"
    />
  </v-menu>
</template>

<script lang="ts">
import { Vue, Component, Prop } from 'vue-property-decorator'

@Component
export default class FormDatePiicker extends Vue {
  @Prop({ required: true }) private propDate!: number[]
  @Prop({ default: false }) isReadOnly!: boolean
  private date = this.propDate.join('-')
  private menu = false
}
</script>

<style lang="scss">
.date-text-field {
  font-size: 80%;
}
</style>
