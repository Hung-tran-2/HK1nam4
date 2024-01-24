<?php
function them(&$ds,$ma,$ten,$malop)  {
    if($ma==""||$ten==""||$malop=="")
        return false;
    foreach ($ds as $lop) {
        foreach($lop as $sv)
            if($sv[0]==$ma)
                return false;
    }
    $ds[$malop][]=array($ma,$ten);
    return true;
}