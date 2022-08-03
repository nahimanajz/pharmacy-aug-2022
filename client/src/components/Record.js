export function Record({data, title}){
    return (
        <div className="info">
            <h3>{title}</h3>
            <table>                
                <tbody>
                    {data?.map( ({A ,B, C}) =>(
                            <tr key={A}>
                               <td >{A}</td> 
                                <td>{B}</td> 
                                <td>{C}</td> 
                            </tr>
                        ))}
                </tbody>
            </table>
            </div>
    )
}