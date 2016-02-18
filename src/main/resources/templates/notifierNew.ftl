<#import "layout.ftl" as layout />

<#assign headerContent>
<link rel="stylesheet" href="/css/notifierNew.css">
</#assign>

<@layout.masterTemplate title="Add Notifier" header=headerContent initScript="js/notifierNew">
<div class="content-container">
    <div class="panel panel-default">
        <div class="panel-heading">
            <h3 class="panel-title">Add Notifier</h3>
        </div>
        <div class="panel-body">
            <form class="form-horizontal">
                <div class="form-group">
                    <label class="col-sm-2 control-label">Title</label>

                    <div class="col-sm-10">
                        <input type="text" class="form-control" v-model="notifier.title">
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-sm-2 control-label">Notify Type</label>

                    <div class="col-sm-10">
                        <select class="form-control" v-model="notifier.type">
                            <option value="wechat">Wechat</option>
                        </select>
                    </div>
                </div>
                <component :is="'notifierConfig-' + notifier.type" :config="notifier.config"></component>
                <div class="form-group">
                    <div class="col-sm-offset-2 col-sm-10">
                        <button type="button" v-on:click="addNotifier" class="btn btn-success">Add</button>
                        <button type="button" v-on:click="testSend" class="btn btn-default">Test</button>
                    </div>
                </div>
            </form>
        </div>
    </div>
</div>
</@layout.masterTemplate>